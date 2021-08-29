$(document).ready(function() {
  $(".minusButton").on("click", (e) => {
    e.preventDefault();
    itemId = $(this).attr("pid");
    qtyInput = $("#quantity" + itemId);
    newQty = parseInt(qtyInput.val()) - 1;
    if (newQty > 0) qtyInput.val(newQty);
  })

  $(".plusButton").on("click", (e) => {
    e.preventDefault();
    itemId = $(this).attr("pid");
    qtyInput = $("#quantity" + itemId);
    newQty = parseInt(qtyInput.val()) + 1;
    if (newQty < 6) qtyInput.val(newQty);
  })
})

// document.getQuerySelector("minusButton").addEventListener("click", event => {
//   event.preventDefault()
//   itemId = this
// })