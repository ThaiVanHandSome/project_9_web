const address = document.querySelector('#addressInp');
const phoneNumber = document.querySelector('#phoneNumberInp');
const listRadio = document.querySelectorAll('.form-check-input-radio');
const note = document.querySelector('#exampleFormControlTextarea1');
const price = document.querySelector('.payment-price-val');
const product = document.querySelector('.payment-product');
const fee = document.querySelector('.payment-fee');
const finalPrice = document.querySelector('.payment-final-price');
const orderDay = document.querySelector('.payment-order-day');
const shipDay = document.querySelector('.payment-ship-day');
const paymentBtn = document.querySelector('.payment-btn');
const agreeCheckbox = document.querySelector('#flexCheckDefault')

var currentDate = new Date();
var day = currentDate.getDate();
var month = currentDate.getMonth() + 1; // Tháng bắt đầu từ 0
var year = currentDate.getFullYear();

var formattedDate = year + '-' + (month < 10 ? '0' + month : month) + '-' + (day < 10 ? '0' + day : day);
orderDay.textContent = formattedDate;

function findDay() {
	let currDay = day;
	let currMonth = month;
	let currYear = year;
	var days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if ((currYear % 400 == 0) || ((currYear % 100 != 0 && currYear % 4 == 0))) {
		days[2] = 29;
	}
	currDay += 3;
	if(currDay > days[month]) {
		currDay = days[month] - currDay;
		currMonth++;
		if(currMonth == 13) {
			currMonth = 1;
			currYear++;
		}
	}
	let dateFormatted = currYear + '-' + (currMonth < 10 ? '0' + currMonth : currMonth) + '-' + (currDay < 10 ? '0' + currDay : currDay);
	return dateFormatted;
}

function convertToVal(str) {
	str = str.slice(0, -1);
	console.log(str);
	return parseInt(str);
}

console.log(price);
console.log(fee);

shipDay.textContent = findDay();
finalPrice.textContent = convertToVal(price.textContent) + convertToVal(fee.textContent) + 'đ';

paymentBtn.addEventListener('click', function() {
	var dataJSON = document.querySelector('.payment-content').getAttribute('data-name');
	console.log(dataJSON);
	data = JSON.parse(dataJSON);
	var orderData = {};
	orderData.address = address.textContent;
	orderData.phoneNumber = phoneNumber.value;
	orderData.note = note.textContent;
	orderData.totalPrice = convertToVal(price.textContent);
	orderData.totalProduct = parseInt(product.textContent);
	orderData.finalPrice = convertToVal(finalPrice.textContent);
	orderData.orderDay = orderDay.textContent;
	orderData.shipDay = shipDay.textContent;
	listRadio.forEach(function(item) {
		if(item.checked) {
			orderData.idPayMethod = item.getAttribute('data-id');
		}
	})
	
	 if (!agreeCheckbox.checked) {
        alert('Bạn cần đồng ý với điều khoản trước khi thanh toán.');
        return;
    }
    
	orderData.list = data.list;
	orderData.orderState = 0;
	var orderDataEncoded = encodeURIComponent(JSON.stringify(orderData));
	var myAnchor = document.createElement('a');
	if(listRadio[1].checked)
	{
		myAnchor.setAttribute('href', '/api/payment/create_payment?cost=' + orderData.finalPrice + '&data=' + orderDataEncoded);
	}
	else
	{
		myAnchor.setAttribute('href', '/payment/order?data=' + orderDataEncoded);
	}
	myAnchor.click();
})





