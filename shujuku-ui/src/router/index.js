import VueRouter from "vue-router";

import Vue from 'vue'
import ManagerIndex from "@/views/ManagerIndex";
import JinGou from "@/views/JinGou";
import CustomerIndex from "@/views/customer/CustomerIndex";
import JiaGou from "@/views/JiaGou";
import ZhuCe from "@/views/ZhuCe";
import LoginCustomer from "@/views/LoginCustomer";
import LoginEmployee from "@/views/LoginEmployee";
import ContolBook from "@/views/book/ContolBook";
import BuyT from "@/views/buy/BuyT";
import SellT from "@/views/customer/SellT";
import BuyBook from "@/views/customer/BuyBook";
import HistoryT from "@/views/customer/HistoryT";
import MyInformation from "@/views/customer/MyInformation";
Vue.use(VueRouter)
//创建并暴露一个路由器
const router = new VueRouter({
    routes:[
        {
            path:'/loginc',
            component:LoginCustomer
        },
        {
            path:'/logine',
            component:LoginEmployee
        },
        {
            path:'/manager',
            component:ManagerIndex,
            children:[
                {
                    path:'jingou',
                    component:JinGou
                },
                {
                    path:'jiagou',
                    component:JiaGou
                },
                {
                    path:'control',
                    component:ContolBook
                },
                {
                    path:'buy',
                    component:BuyT
                },
                {
                    path:'sell',
                    component:SellT
                }
            ]
        },
        {
            path:'/customer',
            component:CustomerIndex,
            children:[
                {
                    path: 'buybook',
                    component: BuyBook
                },
                {
                    path: 'history',
                    component: HistoryT
                },
                {
                    path: 'information',
                    component: MyInformation
                }
            ]
        },
        {
            path:'/zhuce',
            component:ZhuCe
        }
    ]
})

export default router