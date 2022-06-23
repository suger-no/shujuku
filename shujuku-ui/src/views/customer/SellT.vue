<template>
  <div>

    <el-table
        :data="sells"
    >
      <el-table-column
          prop="seId"
          label="id"
          width="180">
      </el-table-column>
      <el-table-column
          prop="bid"
          label="书籍编号"
          width="180">
      </el-table-column>
      <el-table-column
          prop="seQty"
          label="购买数量">
      </el-table-column>
      <el-table-column
          prop="seTime"
          label="销售时间"
          width="200px">
      </el-table-column>
      <el-table-column
          prop="cuId"
          label="顾客编号"
          width="200px">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "SellT",
  data(){
    return{
      sells:[]
    }
  },
  mounted() {
    this.$axios.get("/sell/sells").then((res)=>{
      this.sells=res.data.data
    })
  }
}
</script>

<style scoped>

</style>