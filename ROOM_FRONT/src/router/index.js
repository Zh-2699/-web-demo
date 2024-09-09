import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/fadd',
      component: () => import('.././view/FriendAdd.vue'),
    },{ path: '/fapp',
      component: () => import('.././view/FriendApply.vue'),
    },{ path: '/fli',
        component: () => import('.././view/FriendList.vue'),
      },
   ]
})

export default router
