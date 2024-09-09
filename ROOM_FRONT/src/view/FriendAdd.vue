<template>

  <div :class="hid" class="pop_up" @click="handleHidden">
    <p>好友ID: {{ frined_detail_context.friendId }}</p>
      <p>名字: {{ frined_detail_context.name }}</p>
      <p>年龄: {{ frined_detail_context.age }}</p>
      <p>性别: {{ frined_detail_context.sex }}</p>
      <p>城市: {{ frined_detail_context.city }}</p>
  </div>
  <div :class="all">
    <div class="friend_add">
      <input :class="search_context" type="text" v-model="search_input" placeholder="搜索好友">
      <img class="search_icon" src="../../public/img/search.png" @click="handleSearch">



      <div>
        <ul>
          <li v-for="(friend, index) in filtered_list" :key="friend.friendId">
            <div class="friend_name" @click="frined_detail(index)">{{ friend.name }}</div>
            <button>添加</button>
          </li>
        </ul>
      </div>
    </div>
  </div>


</template>

<script>
export default {
  data() {
    return {
      search_input: '',
      hid: 'hid',
      all: '',
      search_context: '',
      frined_detail_context: {
        friendId: 1003, name: '默认', age: 39, sex: '男', city: '北京'
      },
      // list里存全部数据库中的人
      list: [
          { friendId: 1001, name: 'Alice', url: new URL('.././../public/img/4.png', import.meta.url) },
         { friendId: 1002, name: 'Bob', url: new URL('.././../public/img/5.png', import.meta.url) },
         { friendId: 1003, name: 'Carol', url: new URL('.././../public/img/6.png', import.meta.url) }
      ],
      filtered_list: []
    }
  },
  methods: {
    handleSearch() {
      this.filtered_list = this.list.filter(friend =>
        friend.name.includes(this.search_input)
      );
      if (this.search_input == '') {
        this.filtered_list = []
      }

    },
    handleHidden() {
      this.hid = 'hid'
      this.all = ''
      this.search_context = ''
    },
    frined_detail(index) {
      console.log(this.list[index])
      this.frined_detail_context = this.list[index]
      this.hid = ''
      this.all = 'all'
      this.search_context = 'search_context'
    }
  }
}
</script>
<style>
.all {
  background-color: rgb(122, 123, 123);
  height: 800px;
}

.friend_add {
  margin-top: 20px;
  margin-left: 35%;
}

.search_icon {
  position: absolute;
  height: 30px;
  width: 30px;
  top: 192px;

}

.pop_up {
  height: 500px;
  width: 500px;
  position: absolute;
  background-color: white;
  left: 35%;
  top: 29%;
  z-index: 2;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

.hid {
  visibility: hidden;
}

.friend_name {
  display: inline;
}

.search_context {
  background-color: rgb(122, 123, 123);
}
</style>
