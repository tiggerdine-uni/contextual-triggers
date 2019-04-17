package uk.ac.strath.contextualtriggers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedIntentReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent) {

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()))
        {
            Intent pushIntent = new Intent(context, ContextualTriggersService.class);
            context.startService(pushIntent);
        }
    }
}
