const express = require('express');
const client = require('./client');
const axios = require('axios').default;
const app = express();


app.get('/', async(req,res) => {
    try {
        const cacheValue = await client.get('todos');
        if(cacheValue){
            return res.json(JSON.parse(cacheValue));
        }
        const { data } = await axios.get('https://jsonplaceholder.typicode.com/todos');
        client.set('todos', JSON.stringify(data));
        client.expire('todos', '30*60');
        return res.json(data);
    } catch (error) {
        
    }
})

app.listen(3000, () => {
    console.log('Server listening on 3000');
})