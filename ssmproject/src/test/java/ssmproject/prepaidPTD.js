function pTDFOM() {
    var date = new Date();
    var lastDateOfMonth = LastDateOfCurrentMonth();
    var prepayperiod = "0";
    var dueAtMovein = "43.62";
    var totalMonthly = "104.0";
    var amountPaidDuringMoveIn = "2000.00";
    
    if (prepayperiod > 0) {
        var rent = dueAtMovein+(prepayperiod*totalMonthly); return rent;
    } else {
        var rent = dueAtMovein; return rent;
    }
    var rentValue = rent.replace(/\$/g, '');
    var amountPaidDuringMoveInValue = amountPaidDuringMoveIn.replace(/\$/g, '');
    if (amountPaidDuringMoveIn > dueAtMovein) {
        var moveInPeriod = 1;
        var prepayPeriod = Math.trunc((amountPaidDuringMoveIn-dueAtMovein)/totalMonthly);
        var noOfMonthsPaid = moveInPeriod+prepayPeriod; return noOfMonthsPaid;
    } else {
        var noOfMonthsPaid = Math.trunc((amountPaidDuringMoveInValue / rentValue)); return noOfMonthsPaid;
    }
    if (noOfMonthsPaid !== 1) {
        var paidTroughDateYear = new Date(date.setMonth(date.getMonth() + noOfMonthsPaid));
        var currentMonth = lastDateOfMonth.split("/");
        if (noOfMonthsPaid >= 12) {
            noOfMonthsPaid = noOfMonthsPaid - 12;
            console.log(noOfMonthsPaid);
        }
        var paidTroughDateMonth = parseInt(currentMonth[0]) + noOfMonthsPaid - 1;
        if (paidTroughDateMonth > 12) {
            paidTroughDateMonth = paidTroughDateMonth - 12;
        }
        if (paidTroughDateMonth < 10) {
            paidTroughDateMonth = "0" + paidTroughDateMonth;
        }
        var lastDate = new Date(date.getFullYear(), paidTroughDateMonth, 0);
        var paidTroughDate = paidTroughDateMonth + "/" + lastDate.getDate() + "/" + paidTroughDateYear.getFullYear();
        return paidTroughDate;
        
    } else {
        var paidTroughDate = lastDateOfMonth;
        
        return console.log(paidTroughDate);
    }
}

function LastDateOfCurrentMonth() {
    var date = new Date();
    var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
    console.log(lastDay);
    var Year = lastDay.getFullYear();console.log(Year);
    var Month = lastDay.getMonth() + 1;
    console.log(Month);
    if (Month < 10) {
        Month = "0" + Month;
    }
    var Day = lastDay.getDate();
    if (Day < 10) {
        Day = "0" + Day;
    }
    return console.log(Month + "/" + Day + "/" + Year);
    
}
pTDFOM();