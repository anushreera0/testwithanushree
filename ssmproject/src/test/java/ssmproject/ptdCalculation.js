/**
 * 
 */
 
 
 function pTDFOM() {

var date = "12/19/2022";
var prepayPeriod = 0;
var lastDateOfMonth = LastDateOfCurrentMonth(date, prepayPeriod, amountPaidDuringMoveIn, rent);
var rent = "48.23";
var rentValue = rent.replace(/\$/g, '');
var amountPaidDuringMoveIn = "2000.00";
var amountPaidDuringMoveInValue = amountPaidDuringMoveIn.replace(/\$/g, '');
var noOfMonthsPaid = (amountPaidDuringMoveInValue / rentValue);
if (noOfMonthsPaid !== 1 && Number.isFinite(rentValue)) {
var paidTroughDateYear = new Date(date.setMonth(date.getMonth() + noOfMonthsPaid));
var currentMonth = lastDateOfMonth.split("/");
if (noOfMonthsPaid >= 12) {
noOfMonthsPaid = noOfMonthsPaid - 12;
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

    function LastDateOfCurrentMonth(date, prepayPeriod, amountPaidDuringMoveIn, rent) {
    var date = new Date(date);
    var lastDay = "";

    if (prepayPeriod > 0 && amountPaidDuringMoveIn == rent) {
    lastDay = new Date(date.getFullYear(), date.getMonth() + (prepayPeriod+1), 0);
    } else if (prepayPeriod = 0 && amountPaidDuringMoveIn == rent) {
    lastDay = new Date(date.getFullYear(), date.getMonth() + (prepayPeriod), 0);
    } else if (prepayPeriod = 0 && amountPaidDuringMoveIn < rent) {
        lastDay = "";
        } else {
        lastDay = new Date(date.getFullYear(), date.getMonth() + (prepayPeriod+1), 0);
        }
        var Year = lastDay.getFullYear();
        var Month = lastDay.getMonth() + 1;
        if (Month < 10) {
            Month = "0" + Month;
            }
            var Day = lastDay.getDate();
            if (Day < 10) {
                Day = "0" + Day;
                }
                return 	Month + "/" + Day + "/" + Year;
                }
                pTDFOM();
                
               