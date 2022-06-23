<template>
  <div>
    顾客界面
    <p style="float: right">{{hello}}:{{this.$store.state.cuName}}</p>
    <el-container style="height: 500px; border: 1px solid #eee">

      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <router-link class="choose" to="/customer/buybook">购买图书</router-link>
        <router-link class="choose" to="/customer/history">历史记录</router-link>
        <router-link class="choose" to="/customer/information">个人信息</router-link>
      </el-aside>

      <el-container>
        <router-view/>
      </el-container>
    </el-container>
<!--    123-->
  </div>
</template>

<script>
export default {
  name: "CustomerIndex",
  data(){
    return{
      hello:''
    }
  },
  mounted() {
    var hour = new Date().getHours()
    if(hour>18){
      this.hello='晚上好'
    }else if(hour>14 && hour<=18){
      this.hello='下午好'
    }else if(hour>11 && hour<=14){
      this.hello='中午好'
    }else{
      this.hello='早上好'
    }
  }
}
</script>

<style scoped>
.choose {
  height: 30px;
  //border: rgb(40, 172, 128) 1px solid;
  display: block;
  text-decoration: none;
}
.choose:hover{
  background-color: #15c4b5;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

</style>