/**
 * 
 */
function pTDAD() {

date="1/21/2023";
var rent = "108.00";
var rentValue = rent.replace(/\$/g, '');
var amountPaidDuringMoveIn = "108.00";
var amountPaidDuringMoveInValue = amountPaidDuringMoveIn.replace(/\$/g, '');
var noOfMonthsPaid = (amountPaidDuringMoveInValue / rentValue);
var currentMonth = date.getMonth() + 1;
var lastDate = date.getDate();
if (currentMonth == 12 && noOfMonthsPaid == 1) {
if (lastDate == 1) {
var paidTroughDateYear = new Date(date.setMonth(date.getMonth())).getFullYear();
} else {
var paidTroughDateYear = new Date(date.setMonth(date.getMonth() + 1)).getFullYear();
}
} else {
var paidTroughDateYear = new Date(date.setMonth(date.getMonth() + noOfMonthsPaid)).getFullYear();
}
if (noOfMonthsPaid >= 12) {
noOfMonthsPaid = noOfMonthsPaid - 12;
}
if (lastDate == 1) {
var paidTroughDateMonth = currentMonth + noOfMonthsPaid - 1;
if (paidTroughDateMonth > 12) {
paidTroughDateMonth = paidTroughDateMonth - 12;
}
if (currentMonth == 12) {
if (noOfMonthsPaid == 1) {
lastDate = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();
} else {
lastDate = new Date(date.getFullYear(), date.getMonth() - 1, 0).getDate();
}
} else {
if (noOfMonthsPaid != 1 && lastDate != 1) {
var paidTroughDateMonth = currentMonth + noOfMonthsPaid + 1;
}
lastDate = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
}
} else {
var paidTroughDateMonth = currentMonth + noOfMonthsPaid;
if (paidTroughDateMonth > 12) {
paidTroughDateMonth = paidTroughDateMonth - 12;
}
lastDate = lastDate - 1;
}
if (paidTroughDateMonth < 10) {
    paidTroughDateMonth = "0" + paidTroughDateMonth;
    }
    if (lastDate < 10) {
        lastDate = "0" + lastDate;
        }
        var paidTroughDate = paidTroughDateMonth + "/" + lastDate + "/" + paidTroughDateYear;
        return console.log(paidTroughDate);
        }
        pTDAD();
        