<template>
  <div>
    <el-container>
      <el-header><img class="mlogo" src="">图书管理系统-用户人员</el-header>
      <el-main>
        <el-form :model="customer" ref="ruleForm" label-width="100px" class="zhong">
          <el-form-item label="姓名" prop="cuName">
            <el-input type="text" v-model="customer.cuName"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="customer.cuPassword"></el-input>
          </el-form-item>
          <el-form-item label="电话号码" prop="cuTel">
            <el-input type="text" v-model="customer.cuTel"></el-input>
          </el-form-item>
          <el-form-item label="地址" prop="cuAddresss">
            <el-input type="text" v-model="customer.cuAddresss"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="zc()">注册</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "ZhuCe",
  data(){
    return{
      customer:{
        cuName:'',
        cuAddresss:'',
        cuTel:'',
        cuPasswrod:''
      }
    }
  },
  methods:{
    zc(){
      this.$axios.post("/customer/zhuce",this.customer).then(res=>{
        if(res.data.code==200){
          alert("注册成功")
        }else{
          alert('注册失败')
        }
      })
    }
  }
}
</script>

<style scoped>
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
