<template>
  <div>
    <el-radio-group v-model="labelPosition" size="small" align="center">
<!--      <el-radio-button label="left">左对齐</el-radio-button>-->
<!--      <el-radio-button label="right">右对齐</el-radio-button>-->
      <!--      <el-radio-button label="top">顶部对齐</el-radio-button>-->
    </el-radio-group>
    <div style="margin: 20px;"></div>
    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
      <el-form-item label="书籍编号" class="ff">
        <el-input v-model="formLabelAlign.bId"></el-input>
      </el-form-item>

      <el-form-item label="加购数量" class="ff">
        <el-input v-model="formLabelAlign.number"></el-input>
      </el-form-item>
      <el-form-item label="书本单价" class="ff">
        <el-input v-model="formLabelAlign.price"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
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
      formLabelAlign: {
        bId: '',
        number: '',
        price:''
      }
    };
  },
  methods:{
    jiagou(){
      this.$axios.post('',this.formLabelAlign)
    }
  }
}
</script>

<style scoped>
.ff{
  float: left;
}
</style>