<template>
  <div :class="hid" class="pop_up" @click="handleHidden">
    <p>好友ID: {{ frined_detail_context.friendId }}</p>
      <p>名字: {{ frined_detail_context.name }}</p>
      <p>年龄: {{ frined_detail_context.age }}</p>
      <p>性别: {{ frined_detail_context.sex }}</p>
      <p>城市: {{ frined_detail_context.city }}</p>
   </div>
 
 <div :class="all">
   <table class="friend_apply">
     <tr v-for="(item, index) in list" :key="index" @click="frined_detail(index)">
       <td><img :src="item.url" /></td>

       <td>{{ item.name }}</td>
       <td><button @click.stop="childClick" class="button">同意</button></td>
     </tr>
   </table>
 
 
 </div >
 </template>
 
 <script>
 export default {
   data() {
     return {
       hid:'hid',
       all:'',
       frined_detail_context: {
         friendId: 1003, name: '默认', age: 39, sex: '男', city: '北京'
       },
       // list里存全部数据库中的人
       list: [
         { friendId: 1001, name: 'Alice', url: new URL('.././../public/img/4.png', import.meta.url) },
         { friendId: 1002, name: 'Bob', url: new URL('.././../public/img/5.png', import.meta.url) },
         { friendId: 1003, name: 'Carol', url: new URL('.././../public/img/6.png', import.meta.url) }
       ],
       
     }
   },
   methods: {
 
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
     },
     childClick($event) {
      $event.stopPropagation();
      
    }
   }
 }
 </script>
 <style>
 .all {
   background-color: rgb(122, 123, 123);
   height: 800px;
   padding-top: 35px;
 }
 
 .friend_apply{
   margin-top: 20px;
   margin-left: 35%;
 }
 td{
   height: 50px;
   width: 65px;
 
 }
 td img {
   height: 50px;
   width: 50px;
 
 }
 
 .hid {
   visibility: hidden;
 }
 .button{
  margin-left: 10px;
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
 </style>
 