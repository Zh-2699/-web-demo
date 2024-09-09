<!-- RegisterComponent.vue -->
<template>
  <div>
    <form class="form" @submit.prevent="handleRegister">
      <p class="title">注册</p>
      <p class="message">立即注册并获得我们应用程序的完全访问权限。</p>

      <label>
        <input required="" placeholder="" type="text" class="input" v-model="username">
        <span>用户名</span>
      </label>

      <label>
        <input required="" placeholder="" type="email" class="input" v-model="email">
        <span>邮箱</span>
      </label>

      <label>
        <input required="" placeholder="" type="password" class="input" v-model="password">
        <span>密码</span>
      </label>
      <label>
        <input required="" placeholder="" type="password" class="input" v-model="confirmPassword">
        <span>确认密码</span>
      </label>

      <button class="submit">注册</button>
      <p class="signin">已经拥有账号? <a href="#" @click.prevent="goToSignin">Signin</a></p>
    </form>
  </div>
</template>

<script setup>
    import { defineEmits } from 'vue';
    import {ref} from 'vue'
    import axios from 'axios'
    const username = ref('');
    const password = ref('');
    const email = ref('');
    const confirmPassword = ref('');

    const emit = defineEmits(['switchToLogin']);

    const handleRegister = () => {
        if (password.value === confirmPassword.value ){
            axios.post('http://localhost:8080/user/register', {
                userName: username.value,
                password: password.value,
                email: email.value
            })
            .then(response => {
                if (response.data.code === 200) {
                    console.log('注册成功:', response.data);
                    alert('注册成功！');
                } else {
                    console.error('注册失败:', response.data.message);
                    alert('注册失败: ' + response.data.message); // 显示错误消息
                }
            })
            .catch(error => {
                console.error('请求失败:', error);
                alert('请求失败: ' + error.message); // 显示请求失败的消息
            });
        }else{
            alert('两次输入密码不匹配')
        }    
    };

    const goToSignin = () => {
        emit('switchToLogin');
    };
</script>

<style>
/* 你的样式 */
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

.title::before, .title::after {
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

.form label .input:focus + span, .form label .input:valid + span {
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
