<template>
    <div >
        <el-table
                :data="tableData"
                border
                style="width: 93.5%">
			<el-table-column
			        fixed
					prop="booklistId"
					label="编号"
					width="50">
			</el-table-column>
            <el-table-column                   
                    prop="isbn"
                    label="书号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="bname"
                    label="图书名"
                    width="400">
            </el-table-column>
            <el-table-column
                    prop="publisher"
                    label="出版社"
                    width="150">
            </el-table-column>
			<el-table-column
			        prop="writer"
			        label="作者"
			        width="110">
			</el-table-column>
			<el-table-column
			        prop="ptime"
			        label="出版时间"
			        width="120">
			</el-table-column>
			<el-table-column
			        prop="number"
			        label="数量"
			        width="50">
			</el-table-column>
			<el-table-column
			        prop="operator"
			        label="操作"
			        width="50">
			</el-table-column>
			<el-table-column
			        prop="isPopular"
			        label="欢迎程度"
			        width="100">
			</el-table-column>
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
                axios.get('http://localhost:8181/booklist/findAll/'+currentPage+'/3').then(function(resp){
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
                    booklistId:'', 
                    isbn: '',
                    bname: '',
					publisher:'',
					writer:'',
					ptime:'',
					number:'',
					operator:'',
					isPopular:''					
                }]
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/booklist/findAll/0/3').then(function(resp){
                _this.tableData = resp.data.records
                _this.pageSize = resp.data.size
				_this.total = resp.data.total
            })
        }
    }
</script>