package danish.com.gridlayout;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity mContext;
    private ArrayList<Model> modelArrayList;
    private final static float SMALL_BOX_HEIGHT_IN_DP = 53.25f;
    private final static float FULL_BANNER_HEIGHT_IN_DP = 114.50f;
    private final static int SIZE_1 = 1;
    private final static int SIZE_2 = 2;
    private final static int SIZE_3 = 3;
    private final static int SIZE_4 = 4;
    private int screenWidth;
    private boolean isEven;


    Adapter(Activity activity, ArrayList<Model> modelArrayList, boolean isEven) {
        this.mContext = activity;
        this.modelArrayList = modelArrayList;
        this.isEven = isEven;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,
                false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Model item = getValueAt(position);
        MyViewHolder myViewHolder =
                (MyViewHolder) holder;
        if (item != null) {
            setupValuesInWidgets(myViewHolder, item, position);
        }
    }


    private Model getValueAt(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    private void setupValuesInWidgets(MyViewHolder itemHolder,
                                      Model settingsModel, int pos) {
        if (settingsModel != null) {
            itemHolder.ivLogo.setBackgroundResource(settingsModel.getImage());

            itemHolder.ivLogo.getLayoutParams().height = getPixelFromDips(mContext, SMALL_BOX_HEIGHT_IN_DP);
            if (modelArrayList.size() == SIZE_1) {
                cellForItemOne(itemHolder);
            } else {
                if (isEven) {
                    if (modelArrayList.size() == SIZE_2)
                        cellForItemsTwo(pos, itemHolder);
                    else
                        cellForItemsEven(pos, itemHolder);
                } else
                    cellForItemsOdd(pos, itemHolder);
            }
        }
    }

    private int getPixelFromDips(Context mContext, float pixels) {
        // Get the screen's density scale
        final float scale = mContext.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);

    }

    /**
     * This method is only for one Item when we need to show only one Item in our Grid
     *
     * @param holder
     */
    private void cellForItemOne(MyViewHolder holder) {
        holder.llParent.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, getPixelFromDips(mContext, FULL_BANNER_HEIGHT_IN_DP));

        setItemsMargin(layoutParamsItems, 8, 8, 8, 8);

        holder.ivLogo.setLayoutParams(layoutParamsItems);

    }

    /**
     * This method is only for two Item when we need to show only two Item in our Grid
     *
     * @param holder
     */

    private void cellForItemsTwo(int pos, MyViewHolder holder) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                holder.llParent.getLayoutParams().height
        );
        holder.llParent.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, getPixelFromDips(mContext, FULL_BANNER_HEIGHT_IN_DP)
        );
        if (pos == 0) {
            setItemsMargin(layoutParamsItems, 8, 8, 4, 4);
        } else if (pos == 1) {
            setItemsMargin(layoutParamsItems, 4, 8, 8, 8);
        }
        holder.ivLogo.setLayoutParams(layoutParamsItems);
    }

    /**
     * This method is only for three Item when we need to show only three Item in our Grid
     *
     * @param holder
     */
    private void cellForItemsThree(int pos, MyViewHolder holder) {
        holder.llParent.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        if (pos == 1) {
            LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    getPixelFromDips(mContext, FULL_BANNER_HEIGHT_IN_DP)
            );

            setItemsMargin(layoutParamsItems, 8, 8, 8, 8);
            holder.ivLogo.setLayoutParams(layoutParamsItems);
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int screenWidth = ((displayMetrics.widthPixels) / 2) - getPixelFromDips(mContext, 8);
            LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(screenWidth,
                    holder.ivLogo.getLayoutParams().height);

            if (pos == 0) {
                setItemsMargin(layoutParamsItems, 8, 8, 4, 4);
                holder.ivLogo.setLayoutParams(layoutParamsItems);
            } else if (pos == 2) {
                setItemsMargin(layoutParamsItems, 8, 4, 4, 8);
                holder.ivLogo.setLayoutParams(layoutParamsItems);
            }
        }
    }

    /**
     * This method is only for odd Item when we need to show only odd Item in our Grid
     *
     * @param holder
     */
    private void cellForItemsOdd(int pos, MyViewHolder holder) {
        holder.llParent.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (modelArrayList.size() == 3)
            screenWidth = ((displayMetrics.widthPixels) / 2)-getPixelFromDips(mContext,12);
        else
            screenWidth = ((displayMetrics.widthPixels) / 2);

        if (pos == 0) {
            holder.llParent.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                    screenWidth,
                    holder.ivLogo.getLayoutParams().height
            );

            setItemsMargin(layoutParamsItems, 8, 8, 4, 4);
            holder.ivLogo.setLayoutParams(layoutParamsItems);

        } else if (pos == 1) {
            holder.llParent.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                    screenWidth,
                    holder.ivLogo.getLayoutParams().height
            );

            setItemsMargin(layoutParamsItems, 8, 4, 4, 8);
            holder.ivLogo.setLayoutParams(layoutParamsItems);
        }
        if (pos > 1) {
            if (checkEvenOrOdd(pos)) {
                if (pos == modelArrayList.size() - 1) {
                    StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams)
                            holder.itemView.getLayoutParams();
                    layoutParams.setFullSpan(true);

                    holder.llParent.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    holder.llParent.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                            screenWidth, getPixelFromDips(mContext, FULL_BANNER_HEIGHT_IN_DP)
                    );

                    setItemsMargin(layoutParamsItems, 4, 8, 8, 8);
                    holder.ivLogo.setLayoutParams(layoutParamsItems);

                } else {
                    holder.llParent.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                            screenWidth,
                            holder.ivLogo.getLayoutParams().height
                    );

                    setItemsMargin(layoutParamsItems, 4, 8, 4, 4);
                    holder.ivLogo.setLayoutParams(layoutParamsItems);
                }
            } else {
                holder.llParent.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                        screenWidth,
                        holder.ivLogo.getLayoutParams().height
                );
                setItemsMargin(layoutParamsItems, 4, 4, 4, 8);
                holder.ivLogo.setLayoutParams(layoutParamsItems);
            }
        }
    }

    /**
     * This method is only for even Items when we need to show only even Item in our Grid
     *
     * @param holder
     */
    private void cellForItemsEven(int pos, MyViewHolder holder) {
        holder.llParent.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        holder.llParent.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (modelArrayList.size() == SIZE_4)
            screenWidth = ((displayMetrics.widthPixels) / 2) - getPixelFromDips(mContext, 12);
        else
            screenWidth = ((displayMetrics.widthPixels) / 2);

        LinearLayout.LayoutParams layoutParamsItems = new LinearLayout.LayoutParams(
                screenWidth,
                holder.ivLogo.getLayoutParams().height
        );
        if (pos == 0) {
            setItemsMargin(layoutParamsItems, 8, 8, 4, 4);
            holder.ivLogo.setLayoutParams(layoutParamsItems);
        } else if (pos == 1) {
            setItemsMargin(layoutParamsItems, 8, 4, 4, 8);
            holder.ivLogo.setLayoutParams(layoutParamsItems);
        }
        if (pos > 1) {
            if (checkEvenOrOdd(pos)) {
                if (pos == modelArrayList.size() - 2) {
                    setItemsMargin(layoutParamsItems, 4, 8, 8, 4);
                    holder.ivLogo.setLayoutParams(layoutParamsItems);
                } else {
                    setItemsMargin(layoutParamsItems, 4, 8, 4, 4);
                    holder.ivLogo.setLayoutParams(layoutParamsItems);
                }
            } else {
                if (pos == modelArrayList.size() - 1) {
                    setItemsMargin(layoutParamsItems, 4, 4, 8, 8);
                    holder.ivLogo.setLayoutParams(layoutParamsItems);
                } else {
                    setItemsMargin(layoutParamsItems, 4, 4, 4, 8);
                    holder.ivLogo.setLayoutParams(layoutParamsItems);
                }
            }
        }

    }

    /**
     * This method checks the position is even or odd
     *
     * @param n
     */
    private boolean checkEvenOrOdd(int n) {
        if ((n % 2) == 0) {
            // number is even
            return true;
        } else {
            // number is odd
            return false;


        }
    }

    private void setItemsMargin(LinearLayout.LayoutParams layoutParamsItems, int left, int top, int right, int bottom) {
        layoutParamsItems.setMargins(
                getPixelFromDips(mContext, left),
                getPixelFromDips(mContext, top),
                getPixelFromDips(mContext, right),
                getPixelFromDips(mContext, bottom)
        );
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView ivLogo;
        LinearLayout llParent;

        public MyViewHolder(View view) {
            super(view);

            ivLogo = view.findViewById(R.id.iv_logo);
            llParent = view.findViewById(R.id.ll_parent);
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
