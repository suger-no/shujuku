<template>
  <div>
    <button @click="guanbi()">关闭</button>
    <el-radio-group v-model="labelPosition" size="small" align="center">
      <!--      <el-radio-button label="left">左对齐</el-radio-button>-->
      <!--      <el-radio-button label="right">右对齐</el-radio-button>-->
      <!--      <el-radio-button label="top">顶部对齐</el-radio-button>-->
    </el-radio-group>
    <div style="margin: 20px;"></div>
    <el-form :label-position="labelPosition" label-width="80px" :model="book" ref="bookForm">
      <el-form-item label="书籍编号" class="ff">
        <el-input v-model="book.bId"></el-input>
      </el-form-item>
      <el-form-item label="书籍名称" class="ff">
        <el-input v-model="book.bName"></el-input>
      </el-form-item>
      <el-form-item label="书籍作者" class="ff">
        <el-input v-model="book.bAuthor"></el-input>
      </el-form-item>
      <el-form-item label="书籍类型" class="ff">
        <el-input v-model="book.bType" >
        </el-input>
      </el-form-item>
      <el-form-item label="书籍价格" class="ff">
        <el-input v-model="book.bPrice"></el-input>
      </el-form-item>
      <el-form-item label="进购数量" class="ff">
        <el-input v-model="book.bStock"></el-input>
      </el-form-item>
      <el-form-item label="出版社" class="ff">
        <el-input v-model="book.bPress"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="buy()">修改</el-button>
      </el-form-item>
    </el-form>
    <div>
    </div>
  </div>
</template>

<script>
export default {
  name: "XiuGai",
  data(){
      return{
        book: {
          bType: '',
          bAuthor: '',
          bPress: '',
          bStock:'',
          bPrice:'',
          bName:'',
          bId:''
        }
      }
  },
  props:["bookz","guanbi"],
  mounted() {
    this.book.bId=this.bookz.bid
    this.book.bAuthor=this.bookz.bauthor
    this.book.bPress=this.bookz.bpress
    this.book.bStock=this.bookz.bstock
    this.book.bPrice=this.bookz.bprice
    this.book.bName=this.bookz.bname
    this.book.bType=this.bookz.btype
    console.log(this.book)

  },
  methods:{
    buy(){
      this.$axios.get(`/book/xiugai?bType=${this.book.bType}&bAuthor=${this.book.bAuthor}&bPress=${this.book.bPress}
          &bStock=${this.book.bStock}&bPrice=${this.book.bPrice}&bName=${this.book.bName}&emId=${this.$store.state.emId}&bId=${this.book.bId}`,this.book).then(res=>{
        console.log(res.data)
        // console.log(res.data)
        // console.log(res.headers)
        // const jwt = res.headers['authorization']
        // const userInfo = res.data.data
        //
        // //把数据共享出去
        // this.$store.commit("SET_TOKEN",jwt)
        // this.$store.commit("SET_USERINFO",userInfo)
        //
        // console.log(this.$store.getters.getUser)
        // this.$router.push("/blogs")
        alert(res.data.message)
        this.guanbi()
      })
    }
  }
}
</script>

<style scoped>

</style>