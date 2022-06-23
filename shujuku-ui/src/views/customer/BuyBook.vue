<template>
  <div>
<!--    <div>书籍编号&#45;&#45;名字&#45;&#45;作者&#45;&#45;类型&#45;&#45;库存&#45;&#45;出版商&#45;&#45;价格</div>-->
<!--    <div v-for="book in books" :key="book.bid">-->
<!--      {{book.bid}}-{{book.bname}}&#45;&#45;{{book.bauthor}}&#45;&#45;{{book.btype}}&#45;&#45;{{book.bstock}}&#45;&#45;{{book.bpress}}&#45;&#45;{{book.bprice}}-->
<!--      <button @click="buy(book)">购买</button>-->
<!--    </div>-->
    <el-table
        :data="books"
    >
      <el-table-column
          prop="bid"
          label="书籍编号"
          width="180">
      </el-table-column>
      <el-table-column
          prop="bname"
          label="名字"
          width="180">
      </el-table-column>
      <el-table-column
          prop="bauthor"
          label="作者">
      </el-table-column>
      <el-table-column
          prop="btype"
          label="类型">
      </el-table-column>
      <el-table-column
          prop="bstock"
          label="库存">
      </el-table-column>
      <el-table-column
          prop="bpress"
          label="出版社">
      </el-table-column>
      <el-table-column
          prop="bprice"
          label="价格">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template slot-scope="scope">
          <el-button @click="buy(scope.row)" type="text" size="small">购买</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "BuyBook",
  data(){
    return{
      status:'编辑',
      books:[]
    }
  },
  mounted() {
    this.$axios.get("/book/books").then(res=>{
      this.books=res.data.data
    })
  },
  methods:{
    buy(book){
      this.$axios.post("/book/buyBook?cuId="+this.$store.state.cuId,book).then(res=>{
        alert(res.data.message)
      })
    }
  }
}
</script>

<style scoped>

</style>