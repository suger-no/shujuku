<template>
  <div>
<!--    <div>书籍编号&#45;&#45;名字&#45;&#45;作者&#45;&#45;类型&#45;&#45;库存&#45;&#45;出版商&#45;&#45;价格</div>-->
<!--    <BookT v-for="(book) in books" :key="book.bId" :book="book">-->

<!--    </BookT>-->
    <template >
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
            <el-button @click="chakan(scope.row)" type="text" size="small">修改</el-button>
          </template>
        </el-table-column>
      </el-table>

    </template>

    <XiuGai :bookz="one" :guanbi="guanbi" v-if="display" style="position: absolute;float: lef"/>
  </div>

</template>

<script>
import XiuGai from "@/components/XiuGai";
export default {
  name: "ContolBook",
  components: {XiuGai},
  data(){
    return{
      books:[],
      one:{},
      display: false
    }
  },
  mounted() {
    this.$axios.get("/book/books").then((res)=>{
      this.books=res.data.data
    })
  },
  methods:{
    chakan(bid){
      this.one=bid
      this.display=true
    },
    guanbi(){
      this.display=false
      this.$router.go(0)
    }
  }
}
</script>

<style scoped>

</style>