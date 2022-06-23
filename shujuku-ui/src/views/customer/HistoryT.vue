<template>
  <div>
<!--    id&#45;&#45;书籍编号&#45;&#45;购买数量&#45;&#45;销售时间&#45;&#45;顾客编号-->
<!--    <div v-for="sell in sells" :key="sell.seId">-->
<!--      {{sell.seId}}&#45;&#45;{{sell.bid}}&#45;&#45;{{sell.seQty}}&#45;&#45;{{sell.seTime}}&#45;&#45;{{sell.cuId}}-->
<!--    </div>-->
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
  name: "HistoryT",
  data(){
    return{
      sells:[]
    }
  },
  mounted() {
    this.$axios.get("/sell/sellsId?id="+this.$store.state.cuId).then((res)=>{
      this.sells=res.data.data
    })
  }
}
</script>

<style scoped>

</style>