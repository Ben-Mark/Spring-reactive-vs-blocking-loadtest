var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "2000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "18",
        "ok": "18",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1338",
        "ok": "1338",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "649",
        "ok": "649",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "431",
        "ok": "431",
        "ko": "-"
    },
    "percentiles1": {
        "total": "392",
        "ok": "392",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1105",
        "ok": "1105",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1160",
        "ok": "1160",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1311",
        "ok": "1311",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1098,
    "percentage": 55
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 860,
    "percentage": 43
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 42,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "666.667",
        "ok": "666.667",
        "ko": "-"
    }
},
contents: {
"req_request-1-46da4": {
        type: "REQUEST",
        name: "request_1",
path: "request_1",
pathFormatted: "req_request-1-46da4",
stats: {
    "name": "request_1",
    "numberOfRequests": {
        "total": "2000",
        "ok": "2000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "18",
        "ok": "18",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1338",
        "ok": "1338",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "649",
        "ok": "649",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "431",
        "ok": "431",
        "ko": "-"
    },
    "percentiles1": {
        "total": "392",
        "ok": "392",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1105",
        "ok": "1105",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1160",
        "ok": "1160",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1311",
        "ok": "1311",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1098,
    "percentage": 55
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 860,
    "percentage": 43
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 42,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "666.667",
        "ok": "666.667",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
