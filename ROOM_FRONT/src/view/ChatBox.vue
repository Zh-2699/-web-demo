<template>
    <div class="chat-container">
      <div class="chat-messages">
        <div v-for="(message, index) in messages" :key="index" :class="{'message': true, 'user': message.user === 'me', 'bot': message.user === 'bot'}">
          <p>{{ message.text }}</p>
        </div>
      </div>
      <div class="chat-input">
        <input v-model="newMessage" @keyup.enter="sendMessage" placeholder="Type a message..." />
        <button @click="sendMessage">Send</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, watch } from 'vue';
  
  const messages = ref([]);
  const newMessage = ref('');
  
  const sendMessage = () => {
    if (newMessage.value.trim() !== '') {
      messages.value.push({ text: newMessage.value, user: 'me' });
      newMessage.value = '';
    }
  };
  </script>
  
  <style scoped>
  .chat-container {
    display: flex;
    flex-direction: column;
    height: 100%;
    width: 100%;
    background-color: #f4f4f9;
    border-radius: 10px;
    overflow: hidden;
  }
  
  .chat-messages {
    flex: 1;
    padding: 20px;
    overflow-y: auto;
    display: flex;
    flex-direction: column;
  }
  
  .message {
    padding: 10px 20px;
    border-radius: 20px;
    margin-bottom: 10px;
    max-width: 70%;
    word-wrap: break-word;
  }
  
  .user {
    align-self: flex-end;
    background-color: #007bff;
    color: white;
  }
  
  .bot {
    align-self: flex-start;
    background-color: #e0e0e0;
    color: black;
  }
  
  .chat-input {
    display: flex;
    padding: 10px;
    border-top: 1px solid #ccc;
  }
  
  .chat-input input {
    flex: 1;
    padding: 10px;
    border: none;
    border-radius: 20px;
    margin-right: 10px;
    outline: none;
  }
  
  .chat-input button {
    padding: 10px 20px;
    border: none;
    border-radius: 20px;
    background-color: #007bff;
    color: white;
    cursor: pointer;
  }
  
  .chat-input button:hover {
    background-color: #0056b3;
  }
  </style>
  