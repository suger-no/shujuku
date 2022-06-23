<template>
  <div>
    {{book.bid}}-{{book.bname}}--{{book.bauthor}}--{{book.btype}}--{{book.bstock}}--{{book.bpress}}--{{book.bprice}}
    <button @click="changeStatus()">{{status}}</button>
  </div>
</template>

<script>
export default {
  name: "BookT",
  props:["book"],
  data(){
    return{
      status:'编辑'
    }
  },
  mounted() {
    console.log(this.book)
  },
  methods:{
    changeStatus(){
      if(this.status==='编辑'){
        this.status="完成"
      }else{
        this.$axios.post("/book/change",this.book).then(()=>{

        })
        this.status="编辑"
      }
    }
  }
}
</script>

<style scoped>

</style>