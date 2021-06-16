<template>
  <div class="firstdemo">
    <el-form  :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" class="demo-ruleForm">
			
      <el-row type="flex" justify="center">
        <el-col :span="-10">
          <el-form-item label="用户名" prop="userName">
            <el-input v-model="ruleForm.userName"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
	  
      <el-row type="flex" justify="center">
        <el-col :span="-10">
          <el-form-item label="密码" prop="passWd">
            <el-input v-model="ruleForm.passWd"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
	  
	  
	  <el-row type="flex" justify="center">
	    <el-col :span="-10">
	      <el-form-item label="昵称" prop="rname">
	        <el-input v-model="ruleForm.rname"></el-input>
	      </el-form-item>
	    </el-col>
	  </el-row>
	  
	  <el-row type="flex" justify="center">
	    <el-col :span="-10">
	      <el-form-item label="电话" prop="phone">
	        <el-input v-model="ruleForm.phone"></el-input>
	      </el-form-item>
	    </el-col>
	  </el-row>
	  
	  <el-row type="flex" justify="center">
	    <el-col :span="-10">
	      <el-form-item label="邮箱" prop="email">
	        <el-input v-model="ruleForm.email"></el-input>
	      </el-form-item>
	    </el-col>
	  </el-row>
	  
	  

      <el-row type="flex" justify="center">
        <el-col :span="-10">
          <el-form-item>
            <el-button type="primary"  @click="submitForm('ruleForm')">提交</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
export default {
  name: "fisrtdemo",
  data() {
    return {
      ruleForm: {
        userName: '',
        passWd: '',
		rname: '',
		phone:'',
		email:''
      },
	  
	  rules: {
	      userName: [
	          { required: true, message: '用户名不能为空', trigger: 'blur' }
	      ],
	      passWd:[
	          { required: true, message: '密码不能为空', trigger: 'blur' }
	      ]		  
	  }
	  
    };
  },
  methods: {
		
		submitForm(formName) {
		    const _this = this
		    this.$refs[formName].validate((valid) => {
		        if (valid) {
		            axios.post('http://localhost:8181/reader/register',this.ruleForm).then(function(resp){
		                if(resp.data == 'success'){
		                    _this.$alert('《'+_this.ruleForm.userName+'》注册成功！', '消息', {
		                        confirmButtonText: '确定',
		                        callback: action => {
		                            _this.$router.push('/login')
		                        }
		                    })
			
							
		                }else{
							return false;
						}
						
						
		            })
		        } else {
		            return false;
		        }
		    });
		}
	
  }
};
</script>
<style lang="stylus" scoped></style>