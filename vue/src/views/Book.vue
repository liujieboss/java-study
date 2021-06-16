<template>
    <div >
        <el-table
                :data="tableData"
                border
                style="width: 35.7%">
			<el-table-column
			        fixed
					prop="bookId"
					label="编号"
					width="50">
			</el-table-column>
            <el-table-column                   
                    prop="booklistId"
                    label="图书列表编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="location"
                    label="位置"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="state"
                    label="状态"
                    width="50">
            </el-table-column>
			<el-table-column
			        prop="operator"
			        label="操作"
			        width="50">
			</el-table-column>
			
			
			
			
           <!-- <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column> -->
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {          
            page(currentPage){
                const _this = this;
                axios.get('http://localhost:8181/book/findAll/'+currentPage+'/3').then(function(resp){
					_this.tableData = resp.data.records
                    _this.pageSize = resp.data.size
					_this.total = resp.data.total
					
                })				
				
            }
        },

        data() {
            return {
                pageSize:null,
                total:null,
                tableData: [{
                    bookId:'', 
                    booklistId: '',
                    location: '',
					state:'',
					operator:''					
                }]
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/book/findAll/0/3').then(function(resp){
                _this.tableData = resp.data.records
                _this.pageSize = resp.data.size
				_this.total = resp.data.total
            })
        }
    }
</script>