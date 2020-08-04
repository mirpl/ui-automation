module.exports = async function (browser, event) {
  console.log("event", event);
  
  if (!event.inputParameters.testTargetUrl) {
    throw 'Invalid event data!';
  }

  const page = await browser.newPage();
  await page.goto(event.inputParameters.testTargetUrl);

  await page.click('.add-task__text');
  await (await page.$('.add-task__content')).type(event.inputParameters.taskTitle);
  await page.click('.add-task__submit');
  await page.waitFor(() => !document.querySelector('.add-task__content'));
  
  await page.screenshot({path: process.env.ARTIFACTS_PATH + '/add-task-screenshot-1.png'});

  return { created: 'ok', taskTitle: event.inputParameters.taskTitle };
};


