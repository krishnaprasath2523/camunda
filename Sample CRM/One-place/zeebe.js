console.log('setting up the ZBClient...');

// Import the Zeebe Node.js client
const ZB = require('zeebe-node');

const Duration = ZB.Duration;

// Instantiate a Zeebe client with default localhost settings or environment variables
const zbc = new ZB.ZBClient({
  // longPoll: Duration.days.of(1),
  // pollInterval: Duration.minutes.of(1),
  onReady: () => console.log(`ZBClient Connected!`),
  onConnectionError: (error) => console.log(`ZBClient Disconnected! ${error}`),
  camundaCloud: {
    clientId: process.env.ZEEBE_CLIENT_ID,
    clientSecret: process.env.ZEEBE_CLIENT_SECRET,
    clusterId: process.env.CAMUNDA_CLUSTER_ID,
    clusterRegion: process.env.CAMUNDA_CLUSTER_REGION, // optional, defaults to bru-2
  },
  retry: true,
  maxRetries: -1, // infinite retries
  maxRetryTimeout: Duration.minutes.of(Infinity),
  connectionTolerance: Duration.minutes.of(Infinity),
  loglevel: 'INFO',
});

console.log('setup of the ZBClient is completed');

// Start/Create a process instance of the Camunda workflow process using 'createProcessInstanceWithResult' awaits the outcome
async function startInstance(bpmnProcessId, variables = null) {
  let outcome;
  if (bpmnProcessId) {
    try {
      outcome = await zbc.createProcessInstanceWithResult({
        bpmnProcessId,
        variables,
        requestTimeout: Duration.minutes.of(30),
      });
      // Log the process outcome
      console.log('Process outcome', JSON.stringify(outcome, null, 2));
      return outcome;
    } catch (exception) {
      console.error('Process Error', exception);
    }
  }
  return outcome;
}

// can call like below with proper client details
// result can be null or actual the result object
// const result = await startInstance(process.env.ADD_USER_PROCESS, clientDetails);

exports.startInstance = startInstance;
