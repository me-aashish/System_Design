const { Worker } = require('bullmq');


const ms = () =>{
    return new Promise((res,rej)=>{
        setTimeout(() => {
            res();
        }, 5*1000);
    })
}

const worker = new Worker("email-queue", async(job) => {
    console.log(`Message received with id : ${job.id}`);
    console.log('Processing email');
    console.log(`Sending email to : ${job.data.email}`);
    await ms();
    console.log('Email sent');
});

