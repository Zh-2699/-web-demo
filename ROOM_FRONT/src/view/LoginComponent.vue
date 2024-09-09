<!-- LoginComponent.vue -->
<template>
  <div>
   <form class="form" @submit.prevent="handleLogin">
   <p class="title">登录 </p>
   <p class="message">立即登录并获得我们应用程序的完全访问权限。 </p>
   
      <label>
          <input required="" placeholder="" type="text" class="input" v-model="username">
          <span>用户名</span>
      </label>
       
      <label>
          <input required="" placeholder="" type="password" class="input" v-model="password">
          <span>密码</span>
      </label>
  
   <button class="submit">登录</button>
   <p class="signin">没有账号? <a href="#" @click.prevent="goToRegister">Register</a> </p>
   </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { defineEmits } from 'vue';
import axios from 'axios'; // 导入 axios

const username = ref('');
const password = ref('');
const emit = defineEmits(['switchToRegister', 'loginSuccess']);

const handleLogin = () => {
  axios.post('http://localhost:8080/user/login', {
      userName: username.value,
      password: password.value
  })
  .then(response => {
      if (response.data.code === 200) {
          console.log('登录成功:', response.data);
          const token = response.data.data;
          localStorage.setItem('authToken', token); // 保存token到localStorage
          emit('close'); // 发出关闭事件
          emit('loginSuccess', username.value); // 通知父组件登录成功并传递用户名
          alert('登录成功！');
      } else {
          console.error('登录失败:', response.data.message);
          alert('登录失败: ' + response.data.message); // 显示错误消息
      }
  })
  .catch(error => {
      console.error('请求失败:', error);
      alert('请求失败: ' + error.message); // 显示请求失败的消息
  });
};

const goToRegister = () => {
  emit('switchToRegister');
};
</script>
  
  <style>
  .form {
   display: flex;
   flex-direction: column;
   gap: 10px;
   max-width: 350px;
   background-color: #fff;
   padding: 20px;
   border-radius: 20px;
   position: relative;
 }
 
 .title {
   font-size: 28px;
   color: royalblue;
   font-weight: 600;
   letter-spacing: -1px;
   position: relative;
   display: flex;
   align-items: center;
   padding-left: 30px;
 }
 
 .title::before,.title::after {
   position: absolute;
   content: "";
   height: 16px;
   width: 16px;
   border-radius: 50%;
   left: 0px;
   background-color: royalblue;
 }
 
 .title::before {
   width: 18px;
   height: 18px;
   background-color: royalblue;
 }
 
 .title::after {
   width: 18px;
   height: 18px;
   animation: pulse 1s linear infinite;
 }
 
 .message, .signin {
   color: rgba(88, 87, 87, 0.822);
   font-size: 14px;
 }
 
 .signin {
   text-align: center;
 }
 
 .signin a {
   color: royalblue;
 }
 
 .signin a:hover {
   text-decoration: underline royalblue;
 }
 
 .flex {
   display: flex;
   width: 100%;
   gap: 6px;
 }
 
 .form label {
   position: relative;
 }
 
 .form label .input {
   width: 92.5%;
   padding: 10px 10px 20px 10px;
   outline: 0;
   border: 1px solid rgba(105, 105, 105, 0.397);
   border-radius: 10px;
 }
 
 .form label .input + span {
   position: absolute;
   left: 10px;
   top: 15px;
   color: grey;
   font-size: 0.9em;
   cursor: text;
   transition: 0.3s ease;
 }
 
 .form label .input:placeholder-shown + span {
   top: 15px;
   font-size: 0.9em;
 }
 
 .form label .input:focus + span,.form label .input:valid + span {
   top: 30px;
   font-size: 0.7em;
   font-weight: 600;
 }
 
 .form label .input:valid + span {
   color: green;
 }
 
 .submit {
   border: none;
   outline: none;
   background-color: royalblue;
   padding: 10px;
   border-radius: 10px;
   color: #fff;
   font-size: 16px;
   transform: .3s ease;
   cursor: pointer;
 }
 
 .submit:hover {
   background-color: rgb(56, 90, 194);
 }
 
 @keyframes pulse {
   from {
     transform: scale(0.9);
     opacity: 1;
   }
 
   to {
     transform: scale(1.8);
     opacity: 0;
   }
 }
  </style>