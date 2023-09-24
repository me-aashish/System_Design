const { Queue } = require('bullmq');

const notificationQueue = new Queue('email-queue');

async function messageInit() {
    const res = await notificationQueue.add("email to aashish", {
        email: 'jha.aashish11@gmail.com',
        subject: "demo msg",
        body: "welcome to MQs"
    })

    console.log("Job added to the queue : " , res.id)
}

messageInit();

