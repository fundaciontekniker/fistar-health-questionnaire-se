
/* WRAPPER KNOCKOUT-I18N 
 * The small wrapper file knockout.i18n.js connects knockout with the translation library
**********************************************************/

/*
 * 
 * observable for the current active language
 */

ko.language = ko.observable();

/*
 * returns a computed value for a given key. As it is dependent on the current
 * active language the outcome will change when the language changes.
 */

ko.i18n = function(key) {
  return ko.computed(function() {
    if (ko.language() !== null) {
      return i18n.t(key, {
        lng : ko.language()
      });
    } else {
      return "[...]";
    }
  }, key);
};