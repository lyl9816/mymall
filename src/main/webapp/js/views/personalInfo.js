/**
 * 
 */

function expand(el)
{
 childObj = document.getElementById("child" + el);
 if (childObj.style.display == 'none')
 {
  childObj.style.display = 'block';
 }
 else
 {
  childObj.style.display = 'none';
 }
 return;
}
