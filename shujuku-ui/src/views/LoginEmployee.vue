<template>
  <div>

    <el-container>
      <el-header><img class="mlogo" src="">图书管理系统-管理人员</el-header>
      <el-main>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="zhong">
          <el-form-item label="用户名" prop="emName">
            <el-input type="text" v-model="ruleForm.emName"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="emPassword">
            <el-input type="password" v-model="ruleForm.emPassword"></el-input>
          </el-form-item>
          <el-form-item>
<!--            <el-button type="primary" @click="zc()">注册</el-button>-->
            <el-button type="primary" @click="submitForm('ruleForm')">登入</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "LoginEmployee",
  data() {
    return {
      ruleForm: {
        emName: '',
        emPassword: ''
      },
      rules: {
        emName: [
          { required: true, message: '请输入用户名', trigger: 'change' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
        ],
        emPassword: [
          { required: true, message: '请输入密码', trigger: 'change' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      console.log(3123)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post("/employee/login",this.ruleForm).then(res=>{
            this.$store.auth=res.data.message
            if(res.data.code==200){
              this.$axios=this.$axios.create({
                headers:{
                  'Authorization':res.data.message,
                  'baseURL':'http://127.0.0.1:8082'
                }
              })
              this.$router.push("/manager")
              console.log(res.data.data.emId)
              this.$store.state.emId=res.data.data.emId
            }

            else
              alert('账号或密码错误')
          }).catch(()=>{

          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    zc(){
      this.$router.push("/zhuce")
    }
  },


}
</script>

<style scoped>

.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}


.zhong{
  max-width: 500px;
  margin: 0 auto;
}
</style>
