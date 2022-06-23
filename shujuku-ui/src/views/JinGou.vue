<template>
  <div>
    <i>若要加购书籍，只需填写书籍编号，进购单价（书籍价格），进购数量</i>
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
        <el-select v-model="book.bType" >
          <el-option v-for="(type,iii) in types" :value="type" :key="iii">{{type}}</el-option>
        </el-select>
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
        <el-button type="primary" @click="buy()">添加</el-button>
      </el-form-item>
    </el-form>
    <div>
    </div>
  </div>
</template>

<script>

export default {
  name: "JinGou",
  data() {
    return {
      labelPosition: 'right',
      book: {
        bType: '',
        bAuthor: '',
        bPress: '',
        bStock:'',
        bPrice:'',
        bName:'',
        bId:''
      },
      types:[]
    };
  },
  methods:{
    buy() {
      console.log(3123)
          this.$axios.get(`/book/jin?bType=${this.book.bType}&bAuthor=${this.book.bAuthor}&bPress=${this.book.bPress}
          &bStock=${this.book.bStock}&bPrice=${this.book.bPrice}&bName=${this.book.bName}&emId=${this.$store.state.emId}&bId=${this.book.bId}`).then(res=>{
            console.log(res.data)
            alert(res.data.message)
          }).catch(()=>{
            alert('出错')
          })
    }
  },
  mounted() {
    this.$axios.get(this.$axios.defaults.baseURL+"/book/types").then((res)=>{
      this.types=res.data.data
    })
  }
}
</script>

<style scoped>
.ff{
  //float: left;
  display: inline-block;
}

</style>