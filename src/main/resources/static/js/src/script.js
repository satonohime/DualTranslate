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

document.addEventListener("DOMContentLoaded", ()=> {
    document.getElementById("LangSwapButton").addEventListener("click", swapLang);
})