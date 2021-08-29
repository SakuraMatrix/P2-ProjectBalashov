$(document).ready(function () {
  $("#add2CartBtn").on("click", (e) => {
    addToCart();
  })

})

const addToCart = () => {
  quantity = $("#quantity" + itemId).val()

  url = contextPath + "cart/add/" + itemId

  $.ajax({
    type:"POST",
    url: url,
    beforeSend: function(xhr) {
      xhr.setRequestHeader(crsfHeaderName, csrfValue)
    }
  }).done(function(response) {
    $("#modalTitle").text("Shopping Cart")
    $("#modalTitle").text(response)
    $("#modalTitle").modal()
  }).fail(function() {
    $("#modalTitle").text("Shopping Cart")
    $("#modalTitle").text("Error occurred while adding item to shopping cart.")
    $("#modalTitle").modal()
  })
}