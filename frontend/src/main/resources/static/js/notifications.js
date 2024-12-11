document.addEventListener('DOMContentLoaded', function() {
    console.log('Notifications script loaded!');

    const notificationContainer = document.createElement('div');
    notificationContainer.id = 'notification-container';
    notificationContainer.style.cssText = `
        position: fixed;
        top: 20px;
        right: 20px;
        z-index: 1000;
        max-width: 300px;
    `;
    document.body.appendChild(notificationContainer);

    // Global function to show notifications
    window.showNotification = function(notification) {
        console.log('Notification received:', JSON.stringify(notification));
        
        // Validate notification object
        if (!notification || (!notification.requestId && !notification.content)) {
            console.warn('Invalid notification:', notification);
            return;
        }

        const notificationElement = document.createElement('div');
        
        // Determine background color based on status
        const backgroundColor = notification.status === 'COMPLETADO' 
            ? '#d4edda'   // Green for completed
            : '#f8d7da';  // Red for pending
        const textColor = notification.status === 'COMPLETADO' 
            ? '#155724'   // Dark green text
            : '#721c24';  // Dark red text

        notificationElement.style.cssText = `
            background-color: ${backgroundColor};
            color: ${textColor};
            border: 1px solid ${notification.status === 'COMPLETADO' ? '#c3e6cb' : '#f5c6cb'};
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 5px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            cursor: pointer;
            width: 300px;
            position: absolute;
            right: 20px;
            top: 20px;
        `;

        notificationElement.innerHTML = `
            <strong>Actualización de Viático</strong>
            <p>${notification.content || 'Notificación de solicitud'}</p>
            <small>Viático #${notification.requestId || 'N/A'} - Estado: ${notification.status || 'N/A'}</small>
        `;

        notificationElement.onclick = function() {
            notificationElement.remove();
        };

        notificationContainer.prepend(notificationElement);

        // Auto-remove after 5 seconds
        setTimeout(() => {
            if (notificationElement.parentNode) {
                notificationElement.remove();
            }
        }, 5000);
    };

    // Check for any inline notifications on page load
    const inlineNotificationScripts = document.querySelectorAll('script');
    console.log('Found scripts:', inlineNotificationScripts.length);
    
    inlineNotificationScripts.forEach(script => {
        console.log('Script content:', script.textContent);
        
        // Try to extract notification from script text
        try {
            // Look for a specific pattern in the script
            const matchResult = script.textContent.match(/window\.showNotification\(\{(.*?)\}\)/s);
            if (matchResult) {
                const notificationStr = `{${matchResult[1]}}`;
                const notification = JSON.parse(notificationStr.replace(/'/g, '"'));
                console.log('Parsed notification:', notification);
                window.showNotification(notification);
            }
        } catch (error) {
            console.error('Error parsing notification:', error);
        }
    });

    // Test notification
    setTimeout(() => {
        window.showNotification({
            requestId: 999,
            status: 'COMPLETADO',
            content: 'Viático de prueba completado'
        });
    }, 1000);
});
