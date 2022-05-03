const spinnerDiv = `<div class="d-flex justify-content-center"><div class="spinner-border"></div></div>`

async function getFact() {
    const data = await fetch("https://uselessfacts.jsph.pl/random.json?language=en")
    const json = await data.json()
    return json.text
}

async function displayFact() {
    const factText = document.querySelector("#factText")
    const loadButton = document.querySelector("#loadFact")
    loadButton.setAttribute("disabled", "true")
    factText.innerHTML = spinnerDiv
    const fact = await getFact()
    factText.innerHTML = ""
    factText.innerText = fact
    loadButton.removeAttribute("disabled")
}

function ready() {
    const loadButton = document.querySelector("#loadFact")
    loadButton.addEventListener("click", displayFact)
    displayFact()
}

addEventListener("load", ready)