
//引入vuex
import  Vuex from 'vuex'
import Vue from "vue";

Vue.use(Vuex)
//准备actions--用于响应组件中的动作
const actions = {
    jia(context,value){  //上下文，传入的值
        context.commit('JIA',value)
    }


}
//用于操作数据
const  mutations = {
    JIA(state,value){
        console.log(state)
        state.sum+=value
    }
}
//用于存储数据
const state = {
    cuId:'',
    emId:''
}
//准备getters--用于对state中的数据进行加工


//创建store
const store = new Vuex.Store({
    actions,
    mutations,
    state
})

//导出store
export default store