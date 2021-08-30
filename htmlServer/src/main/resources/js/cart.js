$(document).ready(() => {
    $(".minusButton").on("click", (e) => {
      e.preventDefault();
      decreaseQuantity($(this))
    })

    $(".plusButton").on("click", (e) => {
      e.preventDefault();
      increaseQuantity($(this))
    })

    $(".link-remove").on("click", e => {
      e.preventDefault();
      deleteFromCart($(this))
    })
  updateTotal();

})

const deleteFromCart = () => {
  url = link.attr("href")

  $.ajax({
    type: "POST",
    url: url,
    beforeSend: function (xhr) {
      xhr.setRequestHeader(crsfHeaderName, csrfValue)
    }
  }).done(function (newSubtotal) {
    $("modalTitle").text("Shopping Cart")
    if (response.includes("deleted")) {
      $("#alertModal").on("hide.bs.modal", e => {
        rowNumber = link.attri("rowNumber")
        deleteItem(rowNumber)
        updateTotal()
      })
    }
    $("#modalBody").text(response)
    $("#alertModal").modal()
  }).fail(function () {
    $("#modalTitle").text("Shopping Cart")
    $("#modalBody").text("Error occurred while deleting item(s) from shopping cart.")
    $("#alertModal").modal()
  })
}

const deleteItem = (rowNumber) => {
  rowId = "row" +rowNumber
  $("#" + rowId).remove()
}

const decreaseQuantity = (link) => {
  itemId = $(this).attr("pid")
  qtyInput = $("#quantity" + itemId)

  newQty = parseInt(qtyInput.val()) - 1;
  if (newQty > 0) {
    qtyInputval(newQty);
    updateQuantity(itemId, newQty);
  }
}

const increaseQuantity = (link) => {
  itemId = $(this).attr("pid")
  qtyInput = $("#quantity" + itemId)

  newQty = parseInt(qtyInput.val()) + 1
  if (newQty < 6) {
    qtyInputval(newQty);
    updateQuantity(itemId, newQty);
  }
}

const updateQuantity = (itemId, newQty) => {
  url = contextPath + "cart/update/" + itemId + quantity;

  $.ajax({
    type: "POST",
    url: url,
    beforeSend: function (xhr) {
      xhr.setRequestHeader(crsfHeaderName, csrfValue)
    }
  }).done(function (newSubtotal) {
    updateSubtotal(newSubtotal, itemId);
    updateTotal();
    $("#modalTitle").text("Shopping Cart")
    $("#modalBody").text(response)
    $("#alertModal").modal()
  }).fail(function () {
    $("#modalTitle").text("Shopping Cart")
    $("#modalBody").text("Error occurred while updating quantity in shopping cart.")
    $("#alertModal").modal()
  })
}

const updateSubtotal = (newSubtotal, itemId) => {
  $("#subtotal" + itemId).text(newSubtotal)
}

const updateTotal = () => {
  let total = 0.0

  $(".itemSubtotal").each(index, element) => {
    total = total + parseFloat(element.innerHTML)
  total = String.format("%.2f", total)
  }

  $("#totalAmount").text("$" + total)
}