<template>
    <div>

      <el-container>
        <el-header><img class="mlogo" src="">图书管理系统-用户人员</el-header>
        <el-main>
          <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="zhong">
            <el-form-item label="电话号码" prop="username">
              <el-input type="text" v-model="ruleForm.cuTel"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input type="password" v-model="ruleForm.cuPassword"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="zc()">注册</el-button>
              <el-button type="primary" @click="submitForm('ruleForm')">登入</el-button>
            </el-form-item>
          </el-form>
        </el-main>
      </el-container>
    </div>
</template>

<script>

export default {
  name: "LoginCustomer",
  data() {
    return {
      ruleForm: {
        cuTel: '',
        cuPassword: ''
      }
    };
  },
  methods: {
    submitForm(formName) {
      console.log(3123)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post("/customer/login",this.ruleForm).then(res=>{
            // console.log(res.data)
            if(res.data.code==200){
              this.$router.push("/customer")
              this.$store.state.cuId=res.data.data.cuId
              this.$store.state.cuName=res.data.data.cuName
            }

            else
              alert('账号密码错误')
          }).catch(()=>{
            alert("出错")
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
