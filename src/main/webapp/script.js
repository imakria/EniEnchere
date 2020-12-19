/**
 * Script pour la div selection ON et OFF -----> section filtre page listeEnchere connecte
 */

// Disable checkbox
$("input[value='0']").change(function() {
    $("input[name='mesVentes']").prop('disabled', true);
    $("input[name='mesVentes']").prop('checked', false);
    $("input[name='mesVentesEnCours']").prop('disabled', true);
    $("input[name='ventesNonDebutees']").prop('disabled', true);
    $("input[name='ventesTerminees']").prop('disabled', true);
    $("input[name='encheresOuvertes']").prop('disabled', false);
    $("input[name='mesEncheres']").prop('disabled', false);
    $("input[name='mesEncheresRemportees']").prop('disabled', false);
});

// Enable checkbox
$("input[value='1']").change(function() {
    $("input[name='encheresOuvertes']").prop('disabled', true);
    $("input[name='encheresOuvertes']").prop('checked', false);
    $("input[name='mesEncheres']").prop('disabled', true);
    $("input[name='mesEncheres']").prop('checked', false);
    $("input[name='mesEncheresRemportees']").prop('disabled', true);
    $("input[name='mesEncheresRemportees']").prop('checked', false);
    $("input[name='mesVentes']").prop('disabled', false);
    $("input[name='mesVentesEnCours']").prop('disabled', false);
    $("input[name='ventesNonDebutees']").prop('disabled', false);
    $("input[name='ventesTerminees']").prop('disabled', false);
});




function filterSelection(c) {
    var x, i;
    x = document.getElementsByClassName("filterDiv");
    console.log(x);
    if (c == "30") c = "";
    // Add the "show" class (display:block) to the filtered elements, and remove the "show" class from the elements that are not selected
    for (i = 0; i < x.length; i++) {
        w3RemoveClass(x[i], "show");
        if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
    }
}

// show filtered elements
function w3AddClass(element, name) {
    var i, arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (i = 0; i < arr2.length; i++) {
        if (arr1.indexOf(arr2[i]) == -1) {
            element.className += " " + arr2[i];
        }
    }
}

// Hide elements that are not selected
function w3RemoveClass(element, name) {
    var i, arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (i = 0; i < arr2.length; i++) {
        while (arr1.indexOf(arr2[i]) > -1) {
            arr1.splice(arr1.indexOf(arr2[i]), 1);
        }
    }
    element.className = arr1.join(" ");
}


