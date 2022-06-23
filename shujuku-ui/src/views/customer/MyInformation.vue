<template>
  <div>
    个人信息
    <el-form :label-position="labelPosition" label-width="80px" :model="information">
      <el-form-item label="用户名" class="ff" v-show="false">
        <el-input v-model="information.cuId"></el-input>
      </el-form-item>
      <el-form-item label="用户名" class="ff">
        <el-input v-model="information.cuName"></el-input>
      </el-form-item>
      <el-form-item label="收货地址" class="ff">
        <el-input v-model="information.cuAddresss"></el-input>
      </el-form-item>
      <el-form-item label="密码" class="ff">
        <el-input v-model="information.cuPassword"></el-input>
      </el-form-item>
      <el-form-item label="电话号码" class="ff">
        <el-input v-model="information.cuTel" >
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="xiugai()">修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "MyInformation",
  data(){
    return{
      information:{}
    }
  },
  mounted() {
    this.$axios.get('customer/information?id=1').then(res=>{
      if(res.data.code==200){
        this.information=res.data.data
        console.log(this.information)
      }else{
        alert(res.data.message)
      }
    }).catch(()=>{
      alert('出错')
    })
  },
  methods:{
    xiugai(){
      this.$axios.post('/customer/xiugai',this.information).then(res=>{
        if(res.data.code==200){
          alert('修改成功')
        }else{
          alert('出错')
        }
      }).catch(e=>{
        console.log(e)
        alert('网络出错')
      })
    }
  }
}
</script>

<style scoped>

</style>