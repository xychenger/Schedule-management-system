import {createRouter, createWebHashHistory} from 'vue-router'

import Login from '../components/Login.vue'
import Regist from '../components/Regist.vue'
import ShowSchedule from '../components/ShowSchedule.vue'

import pinia from '../pinia'
import {defineUser} from '../store/userStore'

let sysUser = defineUser(pinia)

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: "/",
            redirect: "/showSchedule"
        },
        {
            path: "/login",
            component: Login
        },
        {
            path: "/regist",
            component: Regist
        },
        {
            path: "/showSchedule",
            component: ShowSchedule
        }
    ]
})
// 通过路由的全局前置守卫， 判断是否可以到达showSchedule
router.beforeEach((to, from, next) => {
    if (to.path == '/showSchedule') {
        // 登录过放行
        if (sysUser.username == '') {
            next('/login')
        }
        // 没登陆过回到登录页
        else {
            next()
        }
    }
    else {
        next()
    }
})

export default router