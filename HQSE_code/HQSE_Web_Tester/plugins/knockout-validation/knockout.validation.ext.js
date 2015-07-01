

// KO EXTENDERS
// -------------------------------------------------------    

ko.validation.rules['requiredNonEmpty'] = {
    validator: function (val, requiredNonEmpty) {
        if (val === undefined || val === null) {
            return true;
        }
	if (!requiredNonEmpty) {
            return true;
        }
        return (val.length > 0);
    }
};
ko.validation.registerExtenders();