<template>
  <div class="firstdemo">
    <el-form  :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" class="demo-ruleForm">
		
	<el-row type="flex" justify="center">
	  <el-col :span="-30">
		<div>
			  <el-avatar align="center" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
		</div>
	  </el-col>
	</el-row>
	
		
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
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登陆</el-button>
            <el-button type="primary" @click="onRegist">注册</el-button>
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
        passWd: ''
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
	    const _this = this;
	    this.$refs[formName].validate((valid) => {
	        if (valid) {
	            axios.get('http://localhost:8181/reader/login/'+_this.ruleForm.userName+'/'+_this.ruleForm.passWd).then(function(resp){
	                if(resp.data == 'success'){
	                    _this.$alert('《'+_this.ruleForm.userName+'》登陆成功！', '消息', {
	                        confirmButtonText: '确定',
	                        callback: action => {
	                            _this.$router.push('/BookManage');
	                        }
	                    })								
	                }else if(resp.data == 'fail'){
					
						_this.$alert('用户名或者密码错误！', '消息', {
						    confirmButtonText: '确定',
						    callback: action => {
						        _this.$router.push('/login');
						    }
						})								
					}else if(resp.data == 'NoUser'){
						_this.$alert('该用户不存在，请注册！', '消息', {
						    confirmButtonText: '确定',
						    callback: action => {
						        _this.$router.push('/register');
						    }
						})		
					}
						
	            })
	        } else {
	            return false;
	        }
	    });
	},
		
	
	onRegist() {
	  this.$router.push({ path: "/register" });
    }
  }
};
</script>
<style lang="stylus" scoped></style>