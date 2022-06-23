<template>
  <div>
    书店后台管理系统
    <el-container style="height: 500px; border: 1px solid #eee">

      <el-aside width="200px" style="background-color: rgb(238, 241, 246)" ref="ee">
        <router-link class="choose" to="/manager/jingou" >进购新书籍</router-link>
<!--        <router-link class="choose" to="/manager/jiagou">加购老书籍</router-link>-->
        <router-link class="choose" to="/manager/control" >管理书籍</router-link>
        <router-link class="choose" to="/manager/buy" >进书记录</router-link>
        <router-link class="choose" to="/manager/sell" >顾客购书记录</router-link>

      </el-aside>

      <el-container>
        <router-view/>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "ManagerIndex",
  mounted() {

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