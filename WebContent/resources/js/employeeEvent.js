jQuery(document).ready(function() {
	jQuery(document).off('click', '#register').on('click', '#register', function(event) {
		var $form = jQuery('#registerEmployeeEventForm');
        $form.submit();
        return false;	
    });
});
