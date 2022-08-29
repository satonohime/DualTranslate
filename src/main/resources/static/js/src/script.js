function swapLang() {
    let langFromText = document.querySelector("#LangFromText");
    let langToText = document.querySelector("#LangToText");

    let langFromTemp = langFromText.textContent;
    langFromText.textContent = langToText.textContent;
    langToText.textContent = langFromTemp;

    let langFrom = document.querySelector("#LangFrom");
    let langTo = document.querySelector("#LangTo");

    langFromTemp = langFrom.value;
    langFrom.value = langTo.value;
    langTo.value = langFromTemp;
}

function submitForm() {
    let form = document.querySelector("#inputform");
    let langFrom = document.querySelector("#LangFrom");

    if (langFrom.value == "en") {
        document.querySelector("#MSResultReading").innerHTML = "";
        document.querySelector("#GResultReading").innerHTML = "";
    }

    form.submit()
}

function setLang() {
    let langFrom = document.querySelector("#LangFrom");
    let langTo = document.querySelector("#LangTo");

    let langFromText = document.querySelector("#LangFromText")
    let langToText = document.querySelector("#LangToText")

    langFrom.value == "ja" ? langFromText.textContent = "Japanese" : langFromText.textContent = "English";
    langTo.value == "ja" ? langToText.textContent = "Japanese" : langToText.textContent = "English";

}

document.addEventListener("DOMContentLoaded", ()=> {
    setLang()
    document.getElementById("LangSwapButton").addEventListener("click", swapLang);
    document.getElementById("TLButton").onclick = "submitForm()"
})