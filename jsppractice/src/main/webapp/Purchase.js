
var addButton = document.getElementById('add').addEventListener('click', addSizeAndQuantityTable)
var removeButton = document.getElementById('remove').addEventListener('click', removeSizeAndQuantityTable)

var trElementSize = document.getElementById('size')
var trElementQty = document.getElementById('quantity')

var noOfTd = document.getElementsByClassName('size').length
var plusButton = document.getElementById('plus')
var minusButton = document.getElementById('minus')

function addSizeAndQuantityTable(){

    var sizeInput = document.createElement('input')
    var qtyInput = document.createElement('input')

    var tdelementSize = document.createElement('td')
    var tdElementQty = document.createElement('td')

    tdelementSize.className = 'size'
    tdElementQty.className = 'quantity'

    sizeInput.name = 'size'
    sizeInput.type = 'number'
    sizeInput.placeholder = 'size'
    sizeInput.required = true

    qtyInput.name = 'quantity'
    qtyInput.type = 'number'
    qtyInput.value = '1'

    tdelementSize.appendChild(sizeInput)
    trElementSize.appendChild(tdelementSize)
    
    tdElementQty.appendChild(qtyInput)
    trElementQty.appendChild(tdElementQty)

    noOfTd++;
    
    if (noOfTd == 6){
        plusButton.disabled = true
    }
    if (noOfTd > 1){
        minusButton.disabled = false
    }
}

function removeSizeAndQuantityTable(){

    trElementSize.removeChild(trElementSize.lastElementChild)
    trElementQty.removeChild(trElementQty.lastElementChild)
    // trElementSize.removeChild(tdelementSize)

    noOfTd = noOfTd -1;

    if(noOfTd <6){
        plusButton.disabled = false
    }
    if (noOfTd <2){
        minusButton.disabled = true
    } 
}

function displayActualPrice(){
    // var actualPrice = 
    document.getElementById("actualPrice").value = document.getElementsByName("mrp")[0].value*(1-document.getElementsByName("discount")[0].value/100)
}

