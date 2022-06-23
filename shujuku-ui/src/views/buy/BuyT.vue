<template>
  <div>

    <el-table
        :data="buys"
    >
      <el-table-column
          prop="buyId"
          label="id"
          width="180">
      </el-table-column>
      <el-table-column
          prop="bsumprice"
          label="金额"
          width="180">
      </el-table-column>
      <el-table-column
          prop="buyQty"
          label="数量">
      </el-table-column>
      <el-table-column
          prop="emId"
          label="管理员id">
      </el-table-column>
      <el-table-column
          prop="buyTime"
          label="时间"
          width="200px">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "BuyT",
  data(){
    return{
      buys:[]
    }
  },
  mounted() {
    this.$axios.get("/buy/buys").then((res)=>{
      this.buys = res.data.data
      console.log(this.buys)
    })
  }
}
</script>

<style scoped>

</style>