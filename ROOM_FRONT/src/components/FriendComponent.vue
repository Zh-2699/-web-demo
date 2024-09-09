<template>
  <div>
    <main class="main-content">
      <div class="main-header">
        <h2>Friends</h2>

        <RouterLink to="/fli">
          <p :class="p1" @click="fun1()">好友列表</p>
        </RouterLink>
        <RouterLink to="/fadd">
          <p :class="p2" @click="fun2()">添加好友</p>
        </RouterLink>
        <RouterLink to="/fapp">
          <p :class="p3" @click="fun3()">好友申请</p>
        </RouterLink>
        <RouterView></RouterView>
      </div>

    </main>

  </div>
</template>

<script>
import { RouterLink, RouterView } from 'vue-router';

export default {
  data() {
    return {
      p1: "p1 active",
      p2: "p2",
      p3: "p2"
    }
  },
  methods: {
    fun1() {
      this.p1 = "p1 active"
      this.p2 = "p2"
      this.p3 = "p2"
    },
    fun2() {
      this.p1 = "p1"
      this.p2 = "p2 active"
      this.p3 = "p2"
    },
    fun3() {
      this.p1 = "p1"
      this.p2 = "p2"
      this.p3 = "p2 active"
    }
  }
}

</script>

<style scoped>
.main-content {
  flex: 1;
  padding: 20px;
  background-color: #f4f4f9;
  height: 800px

  
}

.main-header {

  /* align-items: center; */
height: 100%;
  background-color: #fff;
  padding: 10px;
  border-bottom: 1px solid #ddd;
}

.p1 {
  width: 22%;
  display: inline-block;
  text-align: center;

}

.p2 {
  width: 22%;
  display: inline-block;
  text-align: center;
  margin-left: 10%;
}

.p1:hover {
  background-color: #2081e2;
}

.p2:hover {
  background-color: #2081e2;
}

.active {
  background-color: #2081e2;
}
</style>